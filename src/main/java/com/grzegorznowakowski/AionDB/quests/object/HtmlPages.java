package com.grzegorznowakowski.AionDB.quests.object;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

/**
 * @author Grzegorz Nowakowski
 */
@XmlRootElement(name="HtmlPages")
@XmlAccessorType(XmlAccessType.FIELD)
public class HtmlPages {

    // In progress: [%questname]
    @XmlPath("//HtmlPage[@name='test']/text()")
    private String progress;

    // New quest: [%questname]
    @XmlPath("//HtmlPage[@name='select_acqusitive_quest_desc']/text()")
    private String acqusitive;

    public String getAcqusitive() {
        return acqusitive;
    }

    public void setAcqusitive(String acqusitive) {
        this.acqusitive = acqusitive;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
