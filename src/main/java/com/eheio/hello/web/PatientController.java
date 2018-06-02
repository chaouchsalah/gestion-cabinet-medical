package com.eheio.hello.web;

import com.eheio.hello.model.Mesure;
import com.eheio.hello.model.MesureConsultation;
import com.eheio.hello.model.MesurePatient;
import com.eheio.hello.model.UserInfo;
import com.eheio.hello.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequestMapping("/patient")
class PatientController {
    @Autowired
    IMesurePatientService mesurePatientService;
    @Autowired
    IMesureConsultationService mesureConsultationService;
    @Autowired
    IConsultationService consultationService;
    @Autowired
    IMesureService mesureService;
    @Autowired
    IUserService patientService;
    @Autowired
    MesurePatient mesurePatient;
    @RequestMapping(value = "/mesures", method = RequestMethod.GET)
    public List<MesurePatient> mesures(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int idPatient = patientService.findIdByUsername(auth.getName());
        return mesurePatientService.findByPatient(idPatient);
    }
    @RequestMapping(value = "/mesuresValue", method = RequestMethod.GET)
    public List<MesureConsultation> mesuresValue(Model model) {
        int idConsultation = consultationService.findLastConsultation();
        return mesureConsultationService.findByConsultation(idConsultation);
    }
    @RequestMapping(value = "/mesures", method = RequestMethod.POST)
    public String addMesure(@RequestParam String mesure,@RequestParam String valeur) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int idPatient = patientService.findIdByUsername(auth.getName());
        mesurePatient.setMesure(mesureService.findById(Integer.parseInt(mesure)));
        mesurePatient.setPatient(patientService.findById(idPatient));
        mesurePatientService.addMesure(mesurePatient);
        return "mesures";
    }
}
