package edu.csbsju.whats.happenin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class ViewHappenins extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	List<Happenin> happenins = getHappenins();
    	
    	//populate the view with these happenins
    	//this might be of help:  http://developer.android.com/guide/topics/ui/layout/listview.html#Loader
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_happenins);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_view_happenins, menu);
        return true;
    }
    
    //For now, this is just returns a few hard-coded Happenins.
    //Eventually, it'll have to do a database hit.
    private List<Happenin> getHappenins(){
    	List<Happenin> happenins = new ArrayList<Happenin>();
    	
    	//I'm not populating comments yet.  Assume they'll be visible once a user opens up the Happenin's page
    	//Also, for now, I'll say the rating ranges from 1-4
    	Happenin hap1 = new Happenin();
    	hap1.setName("Hoedown");
    	hap1.setStartTime(new DateTime(2012, 9, 19, 20, 0));
    	hap1.setEndTime(new DateTime(2012, 9, 19, 23, 0));
    	hap1.setLocation("Brother Willie's Pub");
    	hap1.setDescription("A night of dancin' and country music. Bring your cowboy boots!");
    	hap1.setRating(1.0);
    	happenins.add(hap1);
    	
    	Happenin hap2 = new Happenin();
    	hap2.setName("Farmer's Market");
    	hap2.setStartTime(new DateTime(2012, 9, 20, 9, 0));
    	hap2.setEndTime(new DateTime(2012, 9, 20, 3, 0));
    	hap2.setLocation("St. Joseph Farmer's Market");
    	hap2.setDescription("All sorts of fruits and veggies as well as live music from 2 to 3!");
    	hap2.setRating(3.0);
    	happenins.add(hap2);
    	
    	Happenin hap3 = new Happenin();
    	hap3.setName("90's night at Sal's");
    	hap3.setStartTime(new DateTime(2012, 9, 20, 20, 0));
    	hap3.setEndTime(new DateTime(2012, 9, 21, 1, 30));
    	hap3.setLocation("Sal's Bar & Grill");
    	hap3.setDescription("Dress up in your best 90's gear and we'll play all the hits from the dacade!");
    	hap3.setRating(2.5);
    	happenins.add(hap3);
    	
    	Happenin hap4 = new Happenin();
    	hap4.setName("Acoustic Africa");
    	hap4.setStartTime(new DateTime(2012, 9, 20, 19, 0));
    	hap4.setEndTime(new DateTime(2012, 9, 20, 20, 30));
    	hap4.setLocation("Escher Auditorium");
    	hap4.setDescription("3 African women share their music (from the Ivory Coast and Cameroon)" +
    			"and stories with the CSB|SJU and St. Joseph community");
    	hap4.setRating(2.0);
    	happenins.add(hap4);
    	
    	return happenins;
    }
}
