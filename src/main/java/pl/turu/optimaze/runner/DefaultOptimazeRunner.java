package pl.turu.optimaze.runner;

import org.apache.hadoop.mapred.*;

/**
 * Author: Piotr Turek
 */
public class DefaultOptimazeRunner extends AbstractOptimazeRunner {

    private String jobName;
    private Class<Mapper> mapperClass;
    private Class<Reducer> reducerClass;
    private Class<Object> valueClass;
    private Class<InputFormat> inputFormatClass;
    private Class<OutputFormat> outputFormatClass;


    public DefaultOptimazeRunner(String jobName, Class<Mapper> mapperClass, Class<Reducer> reducerClass,
                                 Class<Object> valueClass, Class<InputFormat> inputFormatClass,
                                 Class<OutputFormat> outputFormatClass) {
        this.jobName = jobName;
        this.mapperClass = mapperClass;
        this.reducerClass = reducerClass;
        this.valueClass = valueClass;
        this.inputFormatClass = inputFormatClass;
        this.outputFormatClass = outputFormatClass;
    }

    @Override
    public String getJobName() {
        return jobName;
    }

    @Override
    public Class<Mapper> getMapperClass() {
        return mapperClass;
    }

    @Override
    public Class<Reducer> getReducerClass() {
        return reducerClass;
    }

    @Override
    public Class<Object> getValueClass() {
        return valueClass;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setMapperClass(Class<Mapper> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public void setReducerClass(Class<Reducer> reducerClass) {
        this.reducerClass = reducerClass;
    }

    public void setValueClass(Class<Object> valueClass) {
        this.valueClass = valueClass;
    }

    public void setInputFormatClass(Class<InputFormat> inputFormatClass) {
        this.inputFormatClass = inputFormatClass;
    }

    public void setOutputFormatClass(Class<OutputFormat> outputFormatClass) {
        this.outputFormatClass = outputFormatClass;
    }

    @Override
    public Class<InputFormat> getInputFormat() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Class<OutputFormat> getOutputFormat() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void configureInput(JobConf job) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void configureOutput(JobConf job) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
