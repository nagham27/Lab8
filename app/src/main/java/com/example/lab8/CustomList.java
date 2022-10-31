package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This function returns whether a given city belongs
     * in the city list or not
     * @param city This is the city to search for in the city list
     * @return true if the city was found and false otherwise
     */
    public boolean hasCity(City city){
        if (city == null){
            return false;
        }
        for (int i = 0; i< cities.size() ; i++) {
            City cityItem = cities.get(i);
            if (city.getCityName() == cityItem.getCityName() &&
                    city.getProvinceName() == cityItem.getProvinceName()) {
                return true;
            }
        }
        return false;
    };

    /**
     * Removes all occurrences of a given city in the city list
     * If the city is not found in the list an IllegalArgumentException
     * is thrown
     * @param city This is the city to remove from the city list
     * @throws IllegalArgumentException
     */
    public void delete(City city){

    };
}
