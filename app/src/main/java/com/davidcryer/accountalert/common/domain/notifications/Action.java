package com.davidcryer.accountalert.common.domain.notifications;

class Action {
    private final static String DELIMITER = "_";
    private final static String ACTION_FORMAT = "ACTION" + DELIMITER + "%1$s" + DELIMITER + "%2$s";
    private final String type;
    private final String id;

    Action(String type, String id) {
        this.type = type;
        this.id = id;
    }

    String type() {
        return type;
    }

    String id() {
        return id;
    }

    static Action from(final String action) throws IllegalArgumentException {
        final String[] parts = action.split(DELIMITER, 3);
        if (parts.length == 3) {
            return new Action(parts[1], parts[2]);
        }
        throw new IllegalArgumentException(String.format("Action does not have required format of '%1$s'", ACTION_FORMAT));
    }

    @Override
    public String toString() {
        return String.format(ACTION_FORMAT, type, id);
    }
}
