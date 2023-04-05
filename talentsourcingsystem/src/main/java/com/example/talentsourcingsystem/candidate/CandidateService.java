package com.example.talentsourcingsystem.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long id, Candidate candidate) {
        Candidate existingCandidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid candidate id: " + id));

        existingCandidate.setName(candidate.getName());
        existingCandidate.setContactInfo(candidate.getContactInfo());
        existingCandidate.setInteractions(candidate.getInteractions());
        existingCandidate.setStatus(candidate.getStatus());

        return candidateRepository.save(existingCandidate);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

}
