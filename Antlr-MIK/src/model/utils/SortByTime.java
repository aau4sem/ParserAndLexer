package model.utils;

import model.utils.buildInFunction.BuildInFunction;

import java.util.Comparator;

public class SortByTime implements Comparator<BuildInFunction> {
    public int compare(BuildInFunction a, BuildInFunction b){
        return a.getTime() - b.getTime();
    }
}
