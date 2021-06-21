package com.example.pedrapapeltesouro;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra (View view){
        System.out.println("selecionado pedra");
        this.escolhaUsuario("pedra");
    }

    public void selecionadoTesoura (View view){
        System.out.println("selecionado tesoura");
        this.escolhaUsuario("tesora");
    }

    public void selecionadoPapel (View view){
        System.out.println("selecionado papel");
        this.escolhaUsuario("papel");
    }

    public void escolhaUsuario(String escolhaUsuario){
        System.out.println("item clicado" + escolhaUsuario );

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);


        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra","papel","tesoura"};
        String escolhaApp = opcoes [numero];

        switch (escolhaApp){
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel")) ||
                (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
                (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura"))
        )
        {// app ganhador
            textoResultado.setText("voce perdeu seu bobo :(");

        }else if(
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        )
        {//Usuario ganhador
            textoResultado.setText("voce ganhou, parabens você é demais");

        }else
        {//empate
           textoResultado.setText("empatou :|");
        }

        Log.d( "MainActivity", "item clicado:" + escolhaApp);
    }
}