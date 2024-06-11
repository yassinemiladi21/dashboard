package miladi.yassine.dashboard.data;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;
import miladi.yassine.dashboard.model.Match;


@Configuration
public class BatchConfiguration {

	@Autowired
    private EntityManagerFactory entityManagerFactory;

	// tag::readerwriterprocessor[]
	@Bean
	public FlatFileItemReader<MatchInput> reader() {
		return new FlatFileItemReaderBuilder<MatchInput>()
			.name("matchDataReader")
			.resource(new ClassPathResource("match-data.csv"))
			.delimited()
			.names("id","season","city","date","match_type","player_of_match","venue","team1","team2","toss_winner","toss_decision","winner","result","result_margin","target_runs","target_overs","super_over","method","umpire1","umpire2")
			.targetType(MatchInput.class)
			.build();
	}

	@Bean
	public MatchDataProcessor processor() {
		return new MatchDataProcessor();
	}

	// @Bean
	// public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
	// 	return new JdbcBatchItemWriterBuilder<Match>()
	// 		.sql("INSERT INTO match (id,season,city,date,player_of_match,venue,team1,team2,toss_winner,toss_decision,match_winner,result,result_margin,umpire1,umpire2) VALUES (:id,:season,:city,:date,:playerOfMatch,:venue,:team1,:team2,:tossWinner,:tossDecision,:matchWinner,:result,:resultMargin,:umpire1,:umpire2)")
	// 		.dataSource(dataSource)
	// 		.beanMapped()
	// 		.build();
	// }

	@Bean
    public JpaItemWriter<Match> writer() {
        return new JpaItemWriterBuilder<Match>()
            .entityManagerFactory(entityManagerFactory)
            .build();
    }

	// end::readerwriterprocessor[]

	// tag::jobstep[]
	// @Bean
	// public Job importUserJob(JobRepository jobRepository,Step step1, JobCompletionNotificationListener listener) {
	// 	return new JobBuilder("importUserJob", jobRepository)
	// 		.start(step1)
    //         .listener(listener)
	// 		.build();
	// }

	@Bean
    public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

	// @Bean
	// public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
	// 				  FlatFileItemReader<MatchInput> reader, MatchDataProcessor processor, JdbcBatchItemWriter<Match> writer) {
	// 	return new StepBuilder("step1", jobRepository)
	// 		.<MatchInput, Match> chunk(3, transactionManager)
	// 		.reader(reader)
	// 		.processor(processor)
	// 		.writer(writer)
	// 		.build();
	// }
	// end::jobstep[]


	@Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
            .<MatchInput, Match>chunk(10,transactionManager)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .transactionManager(transactionManager)
            .build();
    }
}