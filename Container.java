package org.hbrs.se1.ws26.exercises.uebung2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Container {

    private final List<Member> members = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        Objects.requireNonNull(member, "Member darf nicht null sein.");

        for (Member existingMember : members) {     //Iteriere und checke duplikate
            if (existingMember.getID().equals(member.getID())) {
                throw new ContainerException(
                        "Das Member-Objekt mit der ID " + member.getID()+ " ist bereits vorhanden!"
                );
            }
        }

        members.add(member);
    }

    public String deleteMember(Integer id) {
        if (id == null) {
            return "Fehler: Die ID darf nicht null sein.";
        }

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getID().equals(id)) {
                members.remove(i);
                return "Member mit der ID " + id + " wurde gelöscht.";
            }
        }

        return "Fehler: Kein Member mit der ID " + id + " vorhanden.";
    }

    public void dump() {
        for (Member member : members) {             //Ausgabe aller Member
            System.out.println(member.toString());
        }
    }

    public int size() {                             //Anzahl der Member im Container
        return members.size();
    }
}
