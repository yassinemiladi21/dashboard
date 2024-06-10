package miladi.yassine.dashboard.data;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.PlatformTransactionManager;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

import miladi.yassine.dashboard.model.MatchRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public FlatFileItemReader<MatchInput> reader() {
        return new FlatFileItemReaderBuilder<MatchInput>()
            .name("matchItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names("season", "city", "date", "playerOfMatch", "venue", "team1", "team2", "tossWinner", "tossDecision", "matchWinner", "result", "resultMargin", "umpire1", "umpire2")
            .targetType(MatchInput.class)
            .build();
    }

    @Bean
    public MatchDataProcessor processor() {
        return new MatchDataProcessor();
    }

    @Bean
    public RepositoryItemWriter<Match> writer(CrudRepository<Match, Long> repository) {
        RepositoryItemWriter<Match> writer = new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, Step step1, JobCompletionNotificationListener listener) {
        return new JobBuilder("importUserJob", jobRepository)
            .listener(listener)
            .start(step1)
            .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                      FlatFileItemReader<MatchInput> reader, ItemProcessor<MatchInput, Match> processor, RepositoryItemWriter<Match> writer) {
        return new StepBuilder("step1", jobRepository)
            .<MatchInput, Match>chunk(3, transactionManager)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build();
    }
}
