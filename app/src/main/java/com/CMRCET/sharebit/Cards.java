package com.CMRCET.sharebit;

public class Cards {
    private String eventTitle;
    private String eventDate;
    private String eventDetails;

    public Cards(String eventTitle,String eventDate,String eventDetails)
    {
        this.eventTitle=eventTitle;
        this.eventDate=eventDate;
        this.eventDetails=eventDetails;
    }
    public String getEventTitle()
    {
        return eventTitle;
    }
    public String getEventDate()
    {
        return eventDate;
    }
    public String getEventDetails()
    {
        return eventDetails;
    }
}

