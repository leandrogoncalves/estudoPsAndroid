package br.com.fiap.si.estudops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
    }


    public void validarCadastro(View v){
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        Intent intent = new Intent(this, ValidaCadastroService.class);

        intent.putExtra("usuario", usuario);
        intent.putExtra("senha", senha);

        startService(intent);
    }
}
