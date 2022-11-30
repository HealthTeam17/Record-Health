package com.healthteam17.recordhealth


import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_patient_reg_form.*


class PatientRegForm : AppCompatActivity() {
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var birthDate: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var residence: EditText
    //private lateinit var radioMaleButton: RadioButton
   // private lateinit var radioFemaleButton: RadioButton
    //private lateinit var radioOtherButton: RadioButton

    //private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_reg_form)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        email = findViewById(R.id.email)
        birthDate = findViewById(R.id.dob)
        phoneNumber = findViewById(R.id.phone)
        residence = findViewById(R.id.residence)
       /* radioMaleButton = findViewById(R.id.radioMaleButton)
        radioOtherButton = findViewById(R.id.radioOtherButton)
        radioFemaleButton = findViewById(R.id.radioFemaleButton)*/

        submitBtn.setOnClickListener {
            val fName = firstName.text.toString().trim()
            val lName = lastName.text.toString().trim()
            val emails = email.text.toString().trim()
            val pNumber = phoneNumber.text.toString().trim()
            val birthDates = birthDate.text.toString().trim()
            val residences = residence.text.toString().trim()
            /*val radioMaleBtn = radioMaleButton.text.toString().trim()
            val radioOtherBtn = radioOtherButton.text.toString().trim()
            val radioFemaleBtn = radioFemaleButton.text.toString().trim()*/


            val userMap = hashMapOf(
                "First Name" to fName,
                "Last Name" to lName,
                "Email Address" to emails,
                "Phone NUmber" to pNumber,
                "Birth Date" to birthDates,
                "Residence" to residences
                /*"Gender Female" to radioFemaleBtn,
                "Gender Male" to radioMaleBtn,
                "Gender Other" to radioOtherBtn*/
            )

            if (fName.isNotEmpty() && lName.isNotEmpty() && emails.isNotEmpty() && pNumber.isNotEmpty() && birthDates.isNotEmpty()
                && residences.isNotEmpty()
            )
                try {
                    // use the add() method to create a document inside users collection
                    FirebaseUtils().fireStoreDatabase.collection("Patient Record").add(userMap)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show()
                            firstName.text.clear()
                            lastName.text.clear()
                            email.text.clear()
                            phoneNumber.text.clear()
                            birthDate.text.clear()
                            residence.text.clear()
                        }
                } catch (e: Exception) {
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                }
            else {
                Toast.makeText(this, "Please fill up the fields :(", Toast.LENGTH_LONG).show()
            }

        }

    }

}
