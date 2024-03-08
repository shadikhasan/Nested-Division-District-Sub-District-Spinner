package com.example.districtspinner;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private String selectedDivision, selectedDistrict, selectedThana;
    private ArrayAdapter<CharSequence> divisionAdapter, districtAdapter, thanaAdapter;
    private Spinner divisionSpinner, districtSpinner, thanaSpinner;
    String[] divisionNames;

    public ArrayAdapter<CharSequence> createThanaAdapter(Context context, int arrayResourceId) {
        return ArrayAdapter.createFromResource(context, arrayResourceId, android.R.layout.simple_spinner_item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        divisionNames = getResources().getStringArray(R.array.Rajshahi);

        divisionSpinner = findViewById(R.id.divisionSpinnerId);
        districtSpinner = findViewById(R.id.districtSpinnerId);
        thanaSpinner = findViewById(R.id.thanaSpinnerId);

        String myString = "divisions";
        int resourceId = getResources().getIdentifier(myString, "array", getPackageName());

        divisionAdapter = ArrayAdapter.createFromResource(this,
                resourceId, android.R.layout.simple_spinner_item);


        // divisionAdapter = ArrayAdapter.createFromResource(this, R.array.divisions, android.R.layout.simple_spinner_item);
        divisionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        divisionSpinner.setAdapter(divisionAdapter);


        divisionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> divisionParent, View view, int i, long l) {

                selectedDivision = divisionSpinner.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(), selectedDivision, Toast.LENGTH_LONG).show();

                int divisionParentId = divisionParent.getId();

                if (divisionParentId == R.id.divisionSpinnerId) {
                    switch (selectedDivision) {
                        case "Select Your Division":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.default_districts, android.R.layout.simple_spinner_item);
                            break;

                        case "Rajshahi":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.Rajshahi, android.R.layout.simple_spinner_item);
                            break;
                        case "Dhaka":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.Dhaka, android.R.layout.simple_spinner_item);
                            break;
                        case "Chattogram":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.Chattogram, android.R.layout.simple_spinner_item);
                            break;
                        case "Barishal":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.Barishal, android.R.layout.simple_spinner_item);
                            break;
                        case "Khulna":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.Khulna, android.R.layout.simple_spinner_item);
                            break;
                        case "Rangpur":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.Rangpur, android.R.layout.simple_spinner_item);
                            break;
                        case "Sylhet":
                            districtAdapter = ArrayAdapter.createFromResource(divisionParent.getContext(),
                                    R.array.Sylhet, android.R.layout.simple_spinner_item);
                            break;
                        case "Mymensingh":
                            districtAdapter = createThanaAdapter(divisionParent.getContext(),
                                    R.array.Mymensingh);
                            break;

                        default:
                            break;
                    }
                }


                districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                districtSpinner.setAdapter(districtAdapter);

                //adding listener to district item
                districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> districtParent, View view, int i, long l) {

                        selectedDistrict = districtSpinner.getSelectedItem().toString();

                        Toast.makeText(getApplicationContext(), selectedDistrict, Toast.LENGTH_LONG).show();

                        int parentId2 = districtParent.getId();

                        if (parentId2 == R.id.districtSpinnerId) {
                            switch (selectedDistrict) {
                                case "Select Your District":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.default_sub_districts, android.R.layout.simple_spinner_item);
                                    break;
                                case "Dhaka":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Dhaka_subdistricts, android.R.layout.simple_spinner_item);
                                    break;
                                case "Faridpur":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Faridpur_subdistricts, android.R.layout.simple_spinner_item);
                                    break;

                                case "Gazipur":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Gazipur_subdistricts, android.R.layout.simple_spinner_item);
                                    break;

                                case "Gopalganj":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Gopalganj_subdistricts, android.R.layout.simple_spinner_item);
                                    break;

                                case "Kishoreganj":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Kishoreganj_subdistricts, android.R.layout.simple_spinner_item);
                                    break;

                                case "Madaripur":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Madaripur_subdistricts, android.R.layout.simple_spinner_item);
                                    break;

                                case "Manikganj":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Manikganj_subdistricts, android.R.layout.simple_spinner_item);
                                    break;

                                case "Munshiganj":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Munshiganj_subdistricts, android.R.layout.simple_spinner_item);
                                    break;

                                case "Narayanganj":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Narayanganj_subdistricts, android.R.layout.simple_spinner_item);
                                    break;
                                case "Narsindi":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Narsingdi_subdistricts, android.R.layout.simple_spinner_item);
                                    break;
                                case "Rajbari":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Rajbari_subdistricts, android.R.layout.simple_spinner_item);
                                    break;
                                case "Shariatpur":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Shariatpur_subdistricts, android.R.layout.simple_spinner_item);
                                    break;
                                case "Tangail":
                                    thanaAdapter = ArrayAdapter.createFromResource(districtParent.getContext(),
                                            R.array.Tangail_subdistricts, android.R.layout.simple_spinner_item);
                                    break;


                                case "Bagerhat":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Bagerhat_subdistricts);
                                    break;
                                case "Chuadanga":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Chuadanga_subdistricts);
                                    break;
                                case "Jessore":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Jessore_subdistricts);
                                    break;
                                // Add more cases for other districts within the Khulna division
                                case "Khulna":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Khulna_subdistricts);
                                    break;
                                case "Kushtia":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Kushtia_subdistricts);
                                    break;
                                case "Magura":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Magura_subdistricts);
                                    break;
                                case "Meherpur":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Meherpur_subdistricts);
                                    break;
                                case "Narail":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Narail_subdistricts);
                                    break;
                                case "Satkhira":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Satkhira_subdistricts);
                                    break;

                                case "Jamalpur":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Jamalpur_subdistricts);
                                    break;
                                case "Mymensingh":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Mymensingh_subdistricts);
                                    break;
                                case "Netrakona":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Netrakona_subdistricts);
                                    break;
                                case "Sherpur":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Sherpur_subdistricts);
                                    break;
                                case "Bogra":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Bogra_subdistricts);
                                    break;
                                case "Chapainawabganj":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Chapainawabganj_subdistricts);
                                    break;
                                case "Joypurhat":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Joypurhat_subdistricts);
                                    break;
                                case "Naogaon":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Naogaon_subdistricts);
                                    break;
                                case "Natore":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Natore_subdistricts);
                                    break;
                                case "Pabna":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Pabna_subdistricts);
                                    break;
                                case "Rajshahi":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Rajshahi_subdistricts);
                                    break;
                                case "Sirajganj":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Sirajganj_subdistricts);
                                    break;

                                case "Dinajpur":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Dinajpur_subdistricts);
                                    break;
                                case "Gaibandha":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Gaibandha_subdistricts);
                                    break;
                                case "Kurigram":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Kurigram_subdistricts);
                                    break;
                                case "Lalmonirhat":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Lalmonirhat_subdistricts);
                                    break;
                                case "Nilphamari":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Nilphamari_subdistricts);
                                    break;
                                case "Panchagarh":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Panchagarh_subdistricts);
                                    break;
                                case "Rangpur":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Rangpur_subdistricts);
                                    break;
                                case "Thakurgaon":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Thakurgaon_subdistricts);
                                    break;
                                case "Habiganj":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Habiganj_subdistricts);
                                    break;
                                case "Moulvibazar":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Moulvibazar_subdistricts);
                                    break;
                                case "Sunamganj":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Sunamganj_subdistricts);
                                    break;
                                case "Sylhet":
                                    thanaAdapter = createThanaAdapter(districtParent.getContext(), R.array.Sylhet_subdistricts);
                                    break;

                                default:
                                    break;
                            }
                        }
                        thanaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        thanaSpinner.setAdapter(thanaAdapter);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}