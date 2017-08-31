package com.seangogo.blogs.pojo.auditable;

/**
 * Created by sean on 2017/8/31.
 */
public interface Validateable {
    interface Persist extends Validateable {
        void persist();
    }

    interface PersistOrUpdate extends Validateable {
        void persistOrUpdate();
    }

    interface Update extends Validateable {
        void update();
    }
}
