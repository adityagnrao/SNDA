/**
 * Created by Aditya Rao on 12/12/13.
 */
import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
public class AgeCounter {
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();
            String[] names=line.split(",");
           int age=Integer.parseInt(names[1]);
            if(age>=5&&age<=14)
            {
                word.set("a");
                output.collect(word, one);
            }
            else
                if(age>=15&&age<=24)
                {
                    word.set("b");
                    output.collect(word, one);
                }
                else
                if(age>=25&&age<=34)
                {
                    word.set("c");
                    output.collect(word, one);
                }
                else
                if(age>=35&&age<=44)
                {
                    word.set("d");
                    output.collect(word, one);
                }
                else
                if(age>=45&&age<=54)
                {
                    word.set("e");
                    output.collect(word, one);
                }
                else
                if(age>=55)
                {
                    word.set("f");
                    output.collect(word, one);
                }
//                StringTokenizer tokenizer = new StringTokenizer(line);
//            while (tokenizer.hasMoreTokens()) {
//                word.set(tokenizer.nextToken());
//                output.collect(word, one);
//
        }
    }
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }
            output.collect(key, new IntWritable(sum));
        }
    }

    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(AgeCounter.class);
        conf.setJobName("AgeCount");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(Map.class);
        conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));

        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
    }
}