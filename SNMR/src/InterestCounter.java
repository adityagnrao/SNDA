/**
 * Created by Aditya Rao on 12/12/13.
 */
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
public class InterestCounter {
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private final static Interests interestarr=new Interests(30);
        private Text word = new Text();

        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();


            String[] names=line.split(",");
            int x=Integer.parseInt(names[3]);
            int y=Integer.parseInt(names[4]);

            for(int j=0;j<30;j++)
            {
                if(names[2].equals(interestarr.interest[j]))
                {
                    if((Math.pow(x-interestarr.x[j],2)+Math.pow(y-interestarr.y[j],2))<=25)
                    {
//                        for(int i=0;i<names.length;i++)
//                        {
                            word.set(names[2]);
                            output.collect(word, one);
//                        }
                    }
                }
            }

//            for(int i=0;i<names.length;i++)
//            {
//                word.set(names[i]);
//                output.collect(word, one);
//            }
//                StringTokenizer tokenizer = new StringTokenizer(line);
//            while (tokenizer.hasMoreTokens()) {
//                word.set(tokenizer.nextToken());
//                output.collect(word, one);
//            }
        }
    }
    public  static class Interests
    {
        public Interests(int num)
        {
           interest= new String[]{"Aircraft", "Art antique collecting", "Astrology", "Baseball", "Basketball", "Bicycling", " Boating sailing ", "Book reading", "Camping hiking", "Casino vacation", "Clothing", "Cooking", "Cosmetics", "Cruise vacation", "Electronics", "Fashion", "Fishing", "Fitness", "Football", "Golf", "History", "Hockey", "Home furnishings", "Household pets", "Hunting", "Jewelry", "Scuba", "Shoes", "Swimming pool", "Tennis"};
            x=new Integer[]{56,93,60,36,60,82,86,31,22,34,33,33,53,79,13,48,88,4,90,33,32,67,19,9,81,52,9,40,41,85};
            y=new Integer[] {74,39,1,85,49,59,22,23,73,25,98,78,85,50,69,79,33,22,32,55,70,75,14,91,63,35,56,58,14,74};


        }
      public  static String[] interest;
    public    Integer[] x,y;
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
        JobConf conf = new JobConf(InterestCounter.class);
        conf.setJobName("InterestCount");

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