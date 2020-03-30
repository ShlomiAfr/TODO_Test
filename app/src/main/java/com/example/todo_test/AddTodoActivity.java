package com.example.todo_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTodoActivity extends AppCompatActivity {

    Button addTaskBtn, goBackToListBtn;
    EditText titleEt, descriptionEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        addTaskBtn =findViewById(R.id.add_new_task_btn);
        titleEt = findViewById(R.id.new_task_title_ET);
        descriptionEt = findViewById(R.id.new_task_description_ET);

        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleEt.getText().toString();
                String description = descriptionEt.getText().toString();

                if (title.equals("") || description.equals("") ){
                    Toast.makeText(AddTodoActivity.this, "Fill in all the Blanks", Toast.LENGTH_SHORT).show();
                    return;
                }

                titleEt.setText("");
                descriptionEt.setText("");

                Task task = new Task(title,description,Status.TODO);
                DataManager.getInstance().addTask(task);

            }
        });

        goBackToListBtn = findViewById(R.id.go_back_to_list);
        goBackToListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
