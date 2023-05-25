package com.essa.mrchaiemc.biz.models.domains.stablediffusion;

import java.io.Serializable;

public class Image2ImageParams implements Serializable {
    /**
     * Text prompt with description of the things you want in the image to be generated.
     */
    protected String key;

    /**
     * Text prompt with description of the things you want in the image to be generated.
     */
    protected String prompt;

    /**
     * Items you don't want in the image.
     */
    protected String negativePrompt;

}
