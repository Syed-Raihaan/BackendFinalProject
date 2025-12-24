package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;

    public Member saveMember(Member member) {
        return memberRepo.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
    }

    public Member updateMember(Long id, Member member) {
        Member existing = getMemberById(id);
        existing.setName(member.getName());
        existing.setPhone(member.getPhone());
        existing.setEmail(member.getEmail());
        return memberRepo.save(existing);
    }

    public void deleteMember(Long id) {
        memberRepo.deleteById(id);
    }

    public List<Member> getMembersByPhone(String phone) {
        return memberRepo.findByPhone(phone);
    }

    public List<Member> getMembersByEmail(String email) {
        return memberRepo.findByEmail(email);
    }
}