package com.assignment3;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.bg.Background;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import java.awt.*;
import java.io.*;
import java.util.*;


public class App {
    public static void main( String[] args ) throws FileNotFoundException, java.io.IOException  {
    	final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
    	final java.util.List <WordFrequency> wordFrequencies = frequencyAnalyzer.load("src/main/java/com/assignment3/radiohead_lotus_flower.txt");
    	final Dimension dimension = new Dimension(600, 600);
    	final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
    	wordCloud.setPadding(0);
    	wordCloud.setBackground(new RectangleBackground(dimension));
    	wordCloud.setColorPalette(new ColorPalette(Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE));
    	wordCloud.setFontScalar(new LinearFontScalar(10, 40));
    	wordCloud.build(wordFrequencies);
    	wordCloud.writeToFile("wordcloud_rectangle.png");
    }
}


