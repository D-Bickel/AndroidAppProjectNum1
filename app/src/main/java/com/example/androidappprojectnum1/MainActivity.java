package com.example.androidappprojectnum1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String url = "https://www.valleycollege.edu";

    Button greet;
    Button website;
    Button email;

    Intent visit_site;
    Intent send_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        greet = (Button)findViewById(R.id.greeting);
        website = (Button)findViewById(R.id.visit);
        email = (Button)findViewById(R.id.email);

        visit_site = new Intent(Intent.ACTION_VIEW);
        send_email = new Intent(Intent.ACTION_VIEW);

        greet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello SBVC!", Toast.LENGTH_SHORT).show();
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visit_site.setData(Uri.parse(url));
                startActivity(visit_site);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_email.setData(Uri.parse("mailto:info@valleycollege.edu"));
                startActivity(send_email);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}