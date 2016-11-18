package com.info.mapreducetest; //Imported package

import java.io.IOException;//Imported hadoop java libraries
import org.apache.hadoop.io.IntWritable; //Imported hadoop java libraries
import org.apache.hadoop.io.Text;//Imported hadoop java libraries
import org.apache.hadoop.mapreduce.Reducer;//Imported hadoop java libraries

public class ReducerTest extends Reducer<Text,IntWritable,Text,IntWritable>{
    //Hear we defined reducerTest class that extends Reducer class with two input & two output parameters
    @Override
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{
        //Here we override reduce method of reduce class
        int count=0; //Set cout variabe to 0
        for(IntWritable one:values){
            count=one.get()+count; //Incremented count of words found multiple times
        }
        context.write(key, new IntWritable(count)); // Here we creates pair of key,value to pass it as a result
    }
    
}
