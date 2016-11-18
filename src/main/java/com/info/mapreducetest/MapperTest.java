package com.info.mapreducetest; // Imported package

import java.io.IOException; //Imported hadoop java libraries
import org.apache.hadoop.io.IntWritable; //Imported hadoop java libraries
import org.apache.hadoop.io.LongWritable; //Imported hadoop java libraries
import org.apache.hadoop.io.Text; //Imported hadoop java libraries
import org.apache.hadoop.mapreduce.Mapper; //Imported hadoop java libraries

public class MapperTest extends Mapper<LongWritable,Text,Text,IntWritable>{
    // Here MappterTest is a class that extends Mapper class with the two input parameteds that is "LongWritable,Text" & two otput parameters i.e "Text,IntWritable"
    IntWritable one=new IntWritable(1); //Created Object of intwritable class
    
    @Override
    public void map(LongWritable key,Text value, Context context) throws IOException, InterruptedException{ //Here we override map method of mapper class
        
        String[] line=value.toString().split(" "); //All the words divied by space passed in split(" ")
        for(String word:line){ //For to get all the words founding after split file with space 
            context.write(new Text(word.toLowerCase()), one); // Here we creates pair of key,value to pass it to reducer
        }
        
    }
}
