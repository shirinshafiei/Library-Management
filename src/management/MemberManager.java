package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String, Member> members;
    // TODO: Define a data structure that stores memberIds and their matching member objects

    public MemberManager() {
        this.members = new CustomHashMap<>();
        // TODO: Initialize your data structure here
    }

    public void addMember(Member member) {
        if (member != null) {
            members.put(member.getMemberId(), member);
        }
        // TODO: Add member and their id to your data structure
    }

    public Member getMember(String memberId) {
        // TODO
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {

        Member member = members.get(memberId);
        if (member != null && transaction != null) {
            member.addTransaction(transaction);
        }// TODO
    }

    public Transaction getLastTransaction(String memberId) {
        // TODO
        Member member = members.get(memberId);
        return member != null ? member.getLastTransaction() : null;
    }
}
