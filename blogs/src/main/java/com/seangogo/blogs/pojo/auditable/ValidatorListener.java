package com.seangogo.blogs.pojo.auditable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Created by sean on 2017/8/31.
 */
public class ValidatorListener {
    private enum Type {
        PERSIST, UPDATE
    }

    @PrePersist
    public void checkPersist(final Object entity) {
        if (entity instanceof Validateable) {
            this.check((Validateable) entity, Type.PERSIST);
        }
    }

    @PreUpdate
    public void checkUpdate(final Object entity) {
        if (entity instanceof Validateable) {
            this.check((Validateable) entity, Type.UPDATE);
        }
    }

    private void check(final Validateable entity, final Type persist) {
        switch (persist) {
            case PERSIST:
                if (entity instanceof Validateable.Persist) {
                    ((Validateable.Persist) entity).persist();
                }
                if (entity instanceof Validateable.PersistOrUpdate) {
                    ((Validateable.PersistOrUpdate) entity).persistOrUpdate();
                }
                break;
            case UPDATE:
                if (entity instanceof Validateable.Update) {
                    ((Validateable.Update) entity).update();
                }
                if (entity instanceof Validateable.PersistOrUpdate) {
                    ((Validateable.PersistOrUpdate) entity).persistOrUpdate();
                }
                break;

            default:
                break;
        }
    }
}
