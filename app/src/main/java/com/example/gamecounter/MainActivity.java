package com.example.gamecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView score; // табло для вывода счёта игры

    private Button SpartakTeam,CSKATeam; // кнопки команд
    private int countSpartak = 0, countCSKA = 0; // счётчики счёт



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        // привязка к полям
        score = findViewById(R.id.score);
        SpartakTeam = findViewById(R.id.ButtonSpartak);
        CSKATeam = findViewById(R.id.ButtonCSKA);
        // обработка нажатия кнопок
        SpartakTeam.setOnClickListener(listener);
        CSKATeam.setOnClickListener(listener);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Запуск активности", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Открытие взаимодействия с активностью", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Отзыв взаимодействия активностью", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop () {
        super.onStop();
        Toast.makeText(this,"Скрытие активности", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        Toast.makeText(this,"Уничтожение активности", Toast.LENGTH_SHORT).show();
    }

    //Определение слушателя
    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ButtonSpartak:
                    countSpartak++;
                    break;
                case R.id.ButtonCSKA:
                    countCSKA++;
                    break;
            }
            //Вывод данных на экран телеофна
            score.setText(String.format("%2d", countSpartak) + " : " + String.format("%2d", countCSKA));

        }


    };
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countSpartak", countSpartak);
        outState.putInt("countCSKA", countCSKA);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        countSpartak = savedInstanceState.getInt("countSpartak");
        countCSKA = savedInstanceState.getInt("countCSKA");
        score.setText(String.format("%2d", countSpartak) + " : " + String.format("%2d", countCSKA));
    }


}

