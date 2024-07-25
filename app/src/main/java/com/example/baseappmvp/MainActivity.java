package com.example.baseappmvp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baseappmvp.interfaces.AlCuadrado;
import com.example.baseappmvp.presenters.AlCuadradoPresenter;

public class MainActivity extends AppCompatActivity implements AlCuadrado.View {
    private TextView tvAlCuadrado;
    private EditText edAlCuadrado;

    private AlCuadrado.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        tvAlCuadrado=(TextView)findViewById(R.id.tvAlCuadrado);
        edAlCuadrado=(EditText)findViewById(R.id.edAlCuadrado);
        presenter = new AlCuadradoPresenter(this);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void calcular (View view){
        presenter.alCuadrado(edAlCuadrado.getText().toString());
    }

    @Override
    public void showResult(String result) {
        tvAlCuadrado.setText(result);
    }

    @Override
    public void showError(String error) {
        tvAlCuadrado.setText(error);
    }
}