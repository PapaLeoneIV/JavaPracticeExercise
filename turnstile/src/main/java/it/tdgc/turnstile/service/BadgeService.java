package it.tdgc.turnstile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tdgc.turnstile.model.Badge;

import it.tdgc.turnstile.repository.BadgeRepository;


@Service
public class BadgeService {

    final private BadgeRepository badgeRepository;

    @Autowired
    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    public Badge getBadgeById(Long id) {
        return badgeRepository.getReferenceById(id);
    }

    public Badge saveBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    public void deleteBadge(Long id) {
        badgeRepository.deleteById(id);
    }

    public void deleteAllBadges() {
        badgeRepository.deleteAll();
    }

    public Badge updateBadge(Long id, Badge badge) {
        Badge badgeToUpdate = badgeRepository.getReferenceById(id);
        badgeToUpdate.setRfid(badge.getRfid());
        return badgeRepository.save(badgeToUpdate);
    }

    // TODO: implement this method
    public Badge getBadgeByRfid(String rfid) {
        return badgeRepository.findByRfid(rfid);
    }
}
