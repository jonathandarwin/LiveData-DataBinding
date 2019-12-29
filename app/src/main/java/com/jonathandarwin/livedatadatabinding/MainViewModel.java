package com.jonathandarwin.livedatadatabinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private List<String> nameList;
    private MutableLiveData<String> name;

    public MainViewModel(){
        // Initiate
        name = new MutableLiveData<>();
        nameList = new ArrayList<>();

        // Set Initial Value
        nameList.add("Andy");
        nameList.add("Barley");
        nameList.add("Charlie");
        nameList.add("Darwin");
        nameList.add("Elton");
        nameList.add("Foster");
        nameList.add("Georgie");
        nameList.add("Harley");
        nameList.add("Ivy");
        nameList.add("Jonathan");
    }

    public LiveData<String> getName(){
        return name;
    }

    public void setName(){
        // Randomize index for nameList
        Random rand = new Random();
        int idx = rand.nextInt(nameList.size());

        name.setValue(nameList.get(idx));
    }
}
