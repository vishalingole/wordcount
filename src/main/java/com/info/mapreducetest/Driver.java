package com.info.mapreducetest; // Imported package

import java.io.IOException; //Inculded java libraries for INPUT/OUTPUT opertaions
import org.apache.hadoop.fs.Path; //Inculded hadoop java libraries 
import org.apache.hadoop.io.IntWritable; //Inculded hadoop java libraries
import org.apache.hadoop.io.Text;//Inculded hadoop java libraries
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;//Inculded hadoop java libraries
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;//Inculded hadoop java libraries
import org.apache.hadoop.mapreduce.Job;//Inculded hadoop java libraries

public class Driver {
    
    public static void main(String... args) throws IOException, InterruptedException, ClassNotFoundException{
        if(args.length<2){ //Check to have both values are provied at the time on input or not that is Input file path & the output path after completing job.
            System.out.println("Usage is [generic option] <input path> <output path>");
            System.exit(1);
        }
        Job job=new Job(); //Created object of job class
        
        job.setJarByClass(Driver.class); //Here we are sending Driver.class jar to mar & reducer to perform task.
        job.setJobName("wordCount"); // Added the name to the running job   
        
        FileInputFormat.setInputPaths(job, new Path(args[0])); //Sets the Input file path provided at the time of input
        FileOutputFormat.setOutputPath(job, new Path(args[1])); // Sets the out put path that where to store result after completing process.
        
        job.setMapperClass(MapperTest.class); //Sets which Mapper get called for the job
        job.setReducerClass(ReducerTest.class);//Sets which Reducer get called for the job.
        
        job.setOutputKeyClass(Text.class); // Setting up data type for the key & key is a string here so we set text.class here
        job.setOutputValueClass(IntWritable.class); // Setting up what data type of this filed while sending outing here it is int.
        
        System.exit(job.waitForCompletion(true)?0:1);
        
    }
}
