package com.prashantkumar957.aktunotes
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.prashantkumar957.aktunotes.Recycler.Adapter
import com.prashantkumar957.aktunotes.Recycler.Model
import com.prashantkumar957.aktunotes.databinding.ActivityHandWrittenBinding
import java.util.Objects

class HandWritten : AppCompatActivity() {
    private lateinit var binding: ActivityHandWrittenBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var subjectList: ArrayList<Model>
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandWrittenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()
        subjectList = ArrayList()
        adapter = Adapter(this, subjectList)

        binding.rcv.adapter = adapter
        binding.rcv.layoutManager = LinearLayoutManager(this);


        loadData();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }




    private fun loadData() {
        subjectList.clear()
        firestore.collection("Subjects").orderBy("id", Query.Direction.ASCENDING)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    Toast.makeText(this, "Error loading subject notes", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }

                if (value != null) {
                    for (dc in value.documentChanges) {
                        if (dc.type == DocumentChange.Type.ADDED) {
                            val model = dc.document.toObject(Model::class.java)
                            subjectList.add(model)
                        }
                    }
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "Subject Notes loaded", Toast.LENGTH_SHORT).show()
                }
            }
    }
}