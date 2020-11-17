package com.example.colordescription;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // создали переменную для спинера и текста
    private Spinner spinnerColors;
    private TextView textViewDescriptions;

    @Override
    // в методе OnCreate присваеваем ссылки переменным spinnerColors textViewDescriptions
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // метод findViewById позволяет найти элемент по Id
        spinnerColors = findViewById(R.id.spinnerColors);
        textViewDescriptions = findViewById(R.id.textViewDescriptionTemp);

    }

    // этот метод отвечает за действие после нажатия кнопки
    // обязательно PV и аргумент View
    public void showDescription(View view) {
        // находим позицию элемента спиннера
        int position = spinnerColors.getSelectedItemPosition();
        // description - описание характера, находится по позиции элемента спинера
        // метод getDescriptionByPosition ниже
        // получим нужное нам описание
        String description = getDescriptionByPosition(position);
        // сделали содержанием текста description
        textViewDescriptions.setText(description);

    }

    // в этом методе мы из масива строк получаем элемент по аргументу метода (position)
    public String getDescriptionByPosition(int position){
        // getResources().getStringArray(R.array.color_description) -- получили данные из массива с Id в XML
        String[] description = getResources().getStringArray(R.array.color_description);
        return description[position];
    }
}