package org.ovmedicine.internnfguide;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AppData {

    public static ArrayList<String> ChapterTitlesList = new ArrayList<String>(Arrays.asList(
            "Cross Covering",
            "Electrolytes",
            "Chest Pain",
            "Shortness of Breath",
            "Abnormal Vital Signs",
            "Fever (full fever work up/FFWU)",
            "Altered Mental Status",
            "Bleeding",
            "Constipation/Nausea",
            "Pain Medication",
            "Sleep",
            "Agitation",
            "Decrease UOP",
            "Seizure",
            "Hyperglycemia",
            "Hypoglycemia",
            "Miscellaneous",
            "References"
    ));

    public static ArrayList<String> SubsessionsTitleList = new ArrayList<String>(Arrays.asList(
            "Overview",
            "Hypokalemia," +
                    "Hyperkalemia," +
                    "Hypomagnesemia," +
                    "Hypocalcemia," +
                    "Hypercalcemia," +
                    "Hypophosphatemia," +
                    "Hyponatremia",
            "Overview," +
                    "ACS," +
                    "Aortic Dissection," +
                    "Cardiac Tamponade," +
                    "Pulmonary Embolism," +
                    "Pneumothorax/Tension Pneumothorax," +
                    "Esophageal Perforation/Boerhaave’s Syndrome",
            "Overview," +
                    "Upper Airway,"+
                    "Pulmonary,"+
                    "Cardiac,"+
                    "Others",
            "Temperature," +
                    "Hypertension," +
                    "Hypotension," +
                    "Tachycardia," +
                    "Bradycardia," +
                    "Low O2 Saturation," +
                    "Tachypnea",

            "Overview," +
                    "Neutropenic Fever",
            "Overview",
            "GI Bleeding," +
                    "After a Cardiac Catheterization (groin access)," +
                    "Permacath Oozing," +
                    "Nosebleed," +
                    "After a Renal Biopsy," +
                    "After a Line is Pulled",
            "Constipation," +
                    "Nausea",
            "Overview," +
                    "Pain Medication Tidbits",
            "Overview",
            "Overview",
            "Overview",
            "Overview",
            "Overview",
            "Overview",
            "“I Fell Down”," +
                    "“I Want to Leave AMA”," +
                    "I Need a Transfusion”," +
                    "Death Note,",
            "Electrolytes," +
                    "Chest Pain," +
                    "Shortness of Breath," +
                    "Temperature," +
                    "Hypertension" +
                    "Hypotension," +
                    "Tachycardia," +
                    "Bradycardia," +
                    "Low O2 Saturation," +
                    "Altered Mental Status," +
                    "Bleeding," +
                    "Constipation/Nausea," +
                    "Pain Medication," +
                    "Sleep," +
                    "Agitation," +
                    "Seizure," +
                    "Hyperglycemia," +
                    "Hypoglycemia," +
                    "Transfusion,"
    ));

   public final static Map<String,String> SectionsLookupMap;
    static {
        SectionsLookupMap = new HashMap<String,String>();
        SectionsLookupMap.put("Upper Airway","Foreign Body,Anaphylaxis,Angioedema");
        SectionsLookupMap.put("Pulmonary","Asthma/COPD Exacerbation,Pulmonary Embolism,Pneumonia,Pulmonary Edema,Pneumothorax");
        SectionsLookupMap.put("Cardiac","ACS,CHF Exacerbation,Arrhythmia");
        SectionsLookupMap.put("Others","Sepsis,DKA,Anemia,Alveolar Hemorrhage");
        SectionsLookupMap.put("Hypertension","Overview,Hypertensive Urgency,Hypertensive Emergency");
        SectionsLookupMap.put("Hypotension","Overview,Hypovolemic,Cardiogenic,Distributive,Obstructive");
        SectionsLookupMap.put("Tachycardia","Overview,Sinus Tachycardia,SVT (AVNRT/AVRT),Atrial Tachycardia,Atrial Fibrillation/Flutter,Multifocal Atrial Tachycardia,Wide Complex Tachycardia");
        SectionsLookupMap.put("Bradycardia","Overview,Sinus Bradycardia,AV Node Block");
        SectionsLookupMap.put("Pain Medication Tidbits","How to Titrate Pain Medication,How to Convert Pain Medications Between Routes/Types,PCA Pump,Abdominal Pain/Dyspepsia,Headache");

    }
}
