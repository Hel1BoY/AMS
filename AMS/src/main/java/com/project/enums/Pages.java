package com.project.enums;

/**
 * Pages enum.
 * Contains redirection page constants.
 *
 * @see com.project.controller.AirlineControllerImpl
 * @see com.project.controller.DestinationControllerImpl
 * @see com.project.controller.AirlineControllerImpl
 * @see com.project.controller.CareersControllerImpl
 */
public enum Pages {
    /** Constant for ... */
    HOME_PAGE("homePage"),
    /** Constant for ... */
    AIRLINES_PAGE("airlinesPage"),
    /** Constant for ... */
    CAREERS_PAGE("careersPage"),
    /** Constant for ... */
    DESTINATIONS_PAGE("destinationsPage");

    private final String page;

    /**
     * Constructor.
     *
     * @param page
     *          the page
     */
    Pages(final String page) {
        this.page = page;
    }

    /**
     * Gets the redirection page.
     *
     * @return the page
     */
    public String getPage() {
        return this.page;
    }

}
