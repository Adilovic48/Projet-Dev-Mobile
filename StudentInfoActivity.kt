import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epsiapp.adapters.StudentAdapter
import com.example.epsiapp.models.Student

class StudentInfoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentList: ArrayList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)

        recyclerView = findViewById(R.id.recycler_view_students)
        recyclerView.layoutManager = LinearLayoutManager(this)

        studentList = ArrayList()
        studentList.add(Student("John Doe", "Etudiant 1"))
        studentList.add(Student("Jane Smith", "Etudiant 2"))
        studentList.add(Student("Robert Brown", "Etudiant 3"))
        studentList.add(Student("Emily White", "Etudiant 4"))

        val adapter = StudentAdapter(studentList)
        recyclerView.adapter = adapter
    }
}
