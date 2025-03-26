package library.inventory;

/**
 * Represents the feeding frequency for different types of pets.
 * This enumeration helps determine how often a pet should be fed.
 */
public enum FeedingSchedule {

    /**
     * Feeding occurs once per day.
     */
    ONCE_DAILY,

    /**
     * Feeding occurs twice per day.
     */
    TWICE_DAILY,

    /**
     * Feeding occurs three times per day.
     */
    THREE_TIMES_DAILY,

    /**
     * Feeding occurs once per week.
     */
    WEEKLY,

    /**
     * Feeding occurs once every two weeks.
     */
    BIWEEKLY
}