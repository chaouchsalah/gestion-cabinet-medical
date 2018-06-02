package com.eheio.hello.web;

import com.eheio.hello.model.*;
import com.eheio.hello.repository.ConsultationRepository;
import com.eheio.hello.repository.MesureRepository;
import com.eheio.hello.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/medecin")
class MedecinController {
    @Autowired
    IConsultationService consultationService;
    @Autowired
    IMesureService mesureService;
    @Autowired
    IUserService patientService;
    @Autowired
    IUserService medecinService;
    @Autowired
    IMesureConsultationService mesureConsultationService;
    @Autowired
    IMaladieService maladieService;
    @Autowired
    IMesurePatientService mesurePatientService;
    @Autowired
    MesureConsultation mesureConsultation;
    @Autowired
    Consultation consultation;
    @Autowired
    Maladie maladie;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello(Model model) {
        List<Consultation> consultations = consultationService.findAll();
        model.addAttribute("consultations",consultations);
        return "consultation";
    }
    @RequestMapping(value = "/consultations", method = RequestMethod.GET)
    public ModelAndView consultationList() {
        ModelAndView mav = new ModelAndView("consultation");
        return mav;
    }
    @RequestMapping(value = "/consultation", method = RequestMethod.GET)
    public ModelAndView consultationForm() {
        ModelAndView mav = new ModelAndView("addConsultation");
        mav.addObject("mesures",mesureService.findAll());
        mav.addObject("patients",patientService.getAllPatients());
        mav.addObject("consultation", consultation);
        return mav;
    }
    @RequestMapping(value = "/consultation", method = RequestMethod.POST)
    public String consultationAction(@ModelAttribute("consultation") Consultation consultation,
                                     @RequestParam String patientSelected,
                                     @RequestParam String maladieStr,
                                     @RequestParam String[] mesures) {

        maladie.setLibelle(maladieStr);
        int idMaladie = maladieService.addMaladie(maladie);
        if(idMaladie!=-1){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserInfo medecin = medecinService.getDataByUserName(auth.getName());
            consultation.setMaladie(maladieService.findById(idMaladie));
            consultation.setPatient(patientService.findById(Integer.parseInt(patientSelected)));
            consultation.setMedecin(medecin);
            consultation.setDateConsultation(new Date());
            int idConsultation = consultationService.addConsultation(consultation);
            for(String mesure : mesures){
                mesureConsultation.setConsultation(consultationService.findById(idConsultation));
                mesureConsultation.setMesure(mesureService.findById(Integer.parseInt(mesure)));
                mesureConsultationService.addMesureConsultation(mesureConsultation);
            }
        }
        return "consultation";
    }
    @ResponseBody
    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public UserInfo findPatients(@RequestParam String patient) {
        return patientService.getPatientData(Integer.parseInt(patient));
    }
    @ResponseBody
    @RequestMapping(value = "/mesuresValue", method = RequestMethod.GET)
    public List<MesurePatient> addMesure(@RequestParam String patient) {
        return mesurePatientService.findByPatient(Integer.parseInt(patient));
    }
}
