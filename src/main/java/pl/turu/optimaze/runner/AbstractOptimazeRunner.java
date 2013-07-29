package pl.turu.optimaze.runner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;

/**
 * Author: Piotr Turek
 */
public abstract class AbstractOptimazeRunner extends Configured implements Tool {

    private static final Logger LOG = Logger.getLogger(AbstractOptimazeRunner.class);

    public abstract String getJobName();
    public abstract Class<Mapper> getMapperClass();
    public abstract Class<Reducer> getReducerClass();
    public abstract Class<Object> getValueClass();
    public abstract Class<InputFormat> getInputFormat();
    public abstract Class<OutputFormat> getOutputFormat();

    public abstract void configureInput(JobConf job);
    public abstract void configureOutput(JobConf job);

    @Override
    public int run(String[] strings) throws Exception {
        Configuration conf = this.getConf();
        JobConf job = new JobConf(conf, this.getClass());

        commonConfig(job);


        configureInput(job);
        configureOutput(job);

        JobClient.runJob(job);

        return 0;
    }

    public static int startOptimaze(String[] args, AbstractOptimazeRunner runner) throws Exception {
        int res = ToolRunner.run(new Configuration(), runner, args);

        return res;
    }

    private void commonConfig(JobConf job) {
        job.setJobName(getJobName());
        job.setOutputKeyClass(getValueClass());
        job.setMapOutputValueClass(getValueClass());
        job.setMapperClass(getMapperClass());
        job.setCombinerClass(getReducerClass());
        job.setReducerClass(getReducerClass());
        job.setInputFormat(getInputFormat());
        job.setOutputFormat(getOutputFormat());
    }

}
