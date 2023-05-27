package com.example.spring_sprint2.services;

import com.example.spring_sprint2.repository.AppReqRepository;
import lombok.RequiredArgsConstructor;
import com.example.spring_sprint2.model.ApplicationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppReqServices {

    private final AppReqRepository appReqRepository;

    public List<ApplicationRequest> getAppRequests() {
        return appReqRepository.findAll();
    }

    public ApplicationRequest getRequest(Long id) {
        return appReqRepository.findById(id).orElse(null);
    }

    public ApplicationRequest changeStatus(Long id) {

        ApplicationRequest applicationRequest = getRequest(id);

        applicationRequest.setHandled(true);

        return appReqRepository.save(applicationRequest);
    }

    public void deleteReq(Long id) {
        appReqRepository.deleteById(id);
    }

    public ApplicationRequest addAppRequest(ApplicationRequest applicationRequest) {
        return appReqRepository.save(applicationRequest);
    }

    public List<ApplicationRequest> unhandledRequestsList() {
        List<ApplicationRequest> applicationRequests = appReqRepository.findAll();

        List<ApplicationRequest> unhandledRequests = applicationRequests.stream()
                .filter(request -> !request.isHandled())
                .collect(Collectors.toList());

        return unhandledRequests;
    }

    public List<ApplicationRequest> handledRequestsList() {
        List<ApplicationRequest> applicationRequests = appReqRepository.findAll();

        List<ApplicationRequest> handledRequests = applicationRequests.stream()
                .filter(request -> request.isHandled())
                .collect(Collectors.toList());

        return handledRequests;
    }
}
