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
            "Fever",
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
            "Welcome," +
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

    public static ArrayList<String> SubsessionsUrlList = new ArrayList<String>(Arrays.asList(
            "welcome.html," +
                "crosscovering.html",
            "electrolytes_hypokalemia.html," +
                    "electrolytes_hyperkalemia.html," +
                    "electrolytes_hypomagnesemia.html," +
                    "electrolytes_hypocalcemia.html," +
                    "electrolytes_hypercalcemia.html," +
                    "electrolytes_hypophophatemia.html," +
                    "electrolytes_hyponatremia.html",
            "chestpain.html," +
                    "chestpain_acs.html," +
                    "chestpain_aorticdissection.html," +
                    "chestpain_cardiactamponade.html," +
                    "chestpain_pulmonaryembolism.html," +
                    "chestpain_pneumothorax.html," +
                    "chestpain_esophagealperforation.html",
            "sob.html," +
                    "sob_upperairway_foreignbody.html,"+
                    "sob_pulmonary_asthmacopd.html," +
                    "sob_cardiac_acs.html," +
                    "sob_others_sepsis.html",
            "abvitalsigns_temp.html," +
                    "abvitalsigns_htn_overview.html," +
                    "abvitalsigns_hypotn_overview.html," +
                    "abvitalsigns_tachy_overview.html," +
                    "abvitalsigns_brady_overview.html," +
                    "abvitalsigns_lowo2sat.html," +
                    "abvitalsigns_tachypnea.html",
            "fever_overview.html," +
                    "fever_neutropenic.html",
            "ams.html",
            "bleeding_gi.html," +
                    "bleeding_aftercath.html," +
                    "bleeding_permacathoozing.html," +
                    "bleeding_nosebleed.html," +
                    "bleeding_afterrenalbx.html," +
                    "bleeding_afterlinepulled.html",
            "constipation.html," +
                    "nausea.html",
            "pain_overview.html," +
                    "pain_titrate.html",
            "sleep.html",
            "agitation.html",
            "decreaseuop.html",
            "sz.html",
            "hyperglycemia.html",
            "hypoglycemia.html",
            "misc_felldown.html," +
                    "misc_leaveama.html," +
                    "misc_transfusion.html," +
                    "misc_deathnote.html",
            "ref_electrolytes.html," +
                    "ref_cp.html," +
                    "ref_sob.html," +
                    "ref_temp.html," +
                    "ref_htn.html," +
                    "ref_hypotension.html," +
                    "ref_tachycardia.html," +
                    "ref_bradycardia.html," +
                    "ref_lowo2sat.html," +
                    "ref_ams.html," +
                    "ref_bleeding.html," +
                    "ref_constipationnausea.html," +
                    "ref_painmed.html," +
                    "ref_sleep.html," +
                    "ref_agitation.html," +
                    "ref_sz.html," +
                    "ref_hyperglycemia.html," +
                    "ref_hypoglycemia.html," +
                    "ref_transfusion.html"
    ));
    public final static Map<String,String> SectionsUrlLookupMap;
    static {
        SectionsUrlLookupMap = new HashMap<String,String>();
        SectionsUrlLookupMap.put("Upper Airway","sob_upperairway_foreignbody.html," +
                "sob_upperairway_anaphylaxis.html," +
                "sob_upperairway_angioedema.html");
        SectionsUrlLookupMap.put("Pulmonary","sob_pulmonary_asthmacopd.html," +
                "sob_pulmonary_pe.html," +
                "sob_pulmonary_pna.html," +
                "sob_pulmonary_pulmedema.html," +
                "sob_pulmonary_pneumothorax.html");
        SectionsUrlLookupMap.put("Cardiac","sob_cardiac_acs.html," +
                "sob_cardiac_chf.html," +
                "sob_cardiac_arrhythmia.html");
        SectionsUrlLookupMap.put("Others","sob_others_sepsis.html," +
                "sob_others_dka.html," +
                "sob_others_anemia.html," +
                "sob_others_alveolarhemorrhage.html");
        SectionsUrlLookupMap.put("Hypertension","abvitalsigns_htn_overview.html," +
                "abvitalsigns_htn_htnurgency.html," +
                "abvitalsigns_htn_htnemergency.html");
        SectionsUrlLookupMap.put("Hypotension","abvitalsigns_hypotn_overview.html," +
                "abvitalsigns_hypotn_hypovolemic.html," +
                "abvitalsigns_hypotn_cardiogenic.html," +
                "abvitalsigns_hypotn_distributive.html," +
                "abvitalsigns_hypotn_obstructive.html");
        SectionsUrlLookupMap.put("Tachycardia","abvitalsigns_tachy_overview.html," +
                "abvitalsigns_tachy_sinustachy.html," +
                "abvitalsigns_tachy_svt.html," +
                "abvitalsigns_tachy_atrialtachy.html," +
                "abvitalsigns_tachy_afibflutter.html," +
                "abvitalsigns_tachy_mat.html," +
                "abvitalsigns_tachy_widecomplextachy.html");
        SectionsUrlLookupMap.put("Bradycardia","abvitalsigns_brady_overview.html," +
                "abvitalsigns_brady_sinus.html," +
                "abvitalsigns_brady_avblock.html");
        SectionsUrlLookupMap.put("Pain Medication Tidbits","pain_titrate.html," +
                "pain_convert.html," +
                "pain_pcapump.html," +
                "pain_abdpain.html," +
                "pain_ha.html");

    }
}
