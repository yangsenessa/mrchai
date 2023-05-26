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

    /**
     * init_image
     * Link to the Initial Image
     */
    private String initImage;

    /**
     * width
     * Max Height: Width: 1024x1024
     */
    private String width;

    /**
     * height
     * Max Height: Width: 1024x1024
     */
    private String height;

    /**
     * samples
     * Number of images to be returned in response. The maximum value is 4.
     */
    private String samples;

    /**
     * num_inference_steps
     * Number of denoising steps. Available values: 21, 31, 41, 51.
     */
    private String numInferenceSteps;

    /**
     * safety_checker
     * A checker for NSFW images. If such an image is detected, it will be replaced by a blank image.
     * default:"no"
     */
    private String safetyChecker;

    /**
     * enhance_prompt
     * Enhance prompts for better results; default: yes, options: yes/no
     */
    private String enhancePromt;

    /**
     * guidance_scale
     * Scale for classifier-free guidance (minimum: 1; maximum: 20)
     */
     private float guidanceScale;

    /**
     * strength
     * Prompt strength when using init image. 1.0 corresponds to full destruction of information in the init image.
     */
    private float strength;

    /**
     * Seed is used to reproduce results,
     * same seed will give you same image in return again.
     * Pass null for a random number.
     */
    private int seed;

    /**
     * webhook
     * Set an URL to get a POST API call once the image generation is complete.
     */
    private String webhook;

    /**
     * track_id
     * This ID is returned in the response to the webhook API call. This will be used to identify the webhook request.
     */
    private String trackId;

    /**
     * Getter method for property <tt>key</tt>.
     *
     * @return property value of key
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter method for property <tt>key</tt>.
     *
     * @param key value to be assigned to property key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Getter method for property <tt>prompt</tt>.
     *
     * @return property value of prompt
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Setter method for property <tt>prompt</tt>.
     *
     * @param prompt value to be assigned to property prompt
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Getter method for property <tt>negativePrompt</tt>.
     *
     * @return property value of negativePrompt
     */
    public String getNegativePrompt() {
        return negativePrompt;
    }

    /**
     * Setter method for property <tt>negativePrompt</tt>.
     *
     * @param negativePrompt value to be assigned to property negativePrompt
     */
    public void setNegativePrompt(String negativePrompt) {
        this.negativePrompt = negativePrompt;
    }

    /**
     * Getter method for property <tt>initImage</tt>.
     *
     * @return property value of initImage
     */
    public String getInitImage() {
        return initImage;
    }

    /**
     * Setter method for property <tt>initImage</tt>.
     *
     * @param initImage value to be assigned to property initImage
     */
    public void setInitImage(String initImage) {
        this.initImage = initImage;
    }

    /**
     * Getter method for property <tt>width</tt>.
     *
     * @return property value of width
     */
    public String getWidth() {
        return width;
    }

    /**
     * Setter method for property <tt>width</tt>.
     *
     * @param width value to be assigned to property width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * Getter method for property <tt>height</tt>.
     *
     * @return property value of height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Setter method for property <tt>height</tt>.
     *
     * @param height value to be assigned to property height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Getter method for property <tt>samples</tt>.
     *
     * @return property value of samples
     */
    public String getSamples() {
        return samples;
    }

    /**
     * Setter method for property <tt>samples</tt>.
     *
     * @param samples value to be assigned to property samples
     */
    public void setSamples(String samples) {
        this.samples = samples;
    }

    /**
     * Getter method for property <tt>numInferenceSteps</tt>.
     *
     * @return property value of numInferenceSteps
     */
    public String getNumInferenceSteps() {
        return numInferenceSteps;
    }

    /**
     * Setter method for property <tt>numInferenceSteps</tt>.
     *
     * @param numInferenceSteps value to be assigned to property numInferenceSteps
     */
    public void setNumInferenceSteps(String numInferenceSteps) {
        this.numInferenceSteps = numInferenceSteps;
    }

    /**
     * Getter method for property <tt>safetyChecker</tt>.
     *
     * @return property value of safetyChecker
     */
    public String getSafetyChecker() {
        return safetyChecker;
    }

    /**
     * Setter method for property <tt>safetyChecker</tt>.
     *
     * @param safetyChecker value to be assigned to property safetyChecker
     */
    public void setSafetyChecker(String safetyChecker) {
        this.safetyChecker = safetyChecker;
    }

    /**
     * Getter method for property <tt>enhancePromt</tt>.
     *
     * @return property value of enhancePromt
     */
    public String getEnhancePromt() {
        return enhancePromt;
    }

    /**
     * Setter method for property <tt>enhancePromt</tt>.
     *
     * @param enhancePromt value to be assigned to property enhancePromt
     */
    public void setEnhancePromt(String enhancePromt) {
        this.enhancePromt = enhancePromt;
    }

    /**
     * Getter method for property <tt>guidanceScale</tt>.
     *
     * @return property value of guidanceScale
     */
    public float getGuidanceScale() {
        return guidanceScale;
    }

    /**
     * Setter method for property <tt>guidanceScale</tt>.
     *
     * @param guidanceScale value to be assigned to property guidanceScale
     */
    public void setGuidanceScale(float guidanceScale) {
        this.guidanceScale = guidanceScale;
    }

    /**
     * Getter method for property <tt>strength</tt>.
     *
     * @return property value of strength
     */
    public float getStrength() {
        return strength;
    }

    /**
     * Setter method for property <tt>strength</tt>.
     *
     * @param strength value to be assigned to property strength
     */
    public void setStrength(float strength) {
        this.strength = strength;
    }

    /**
     * Getter method for property <tt>seed</tt>.
     *
     * @return property value of seed
     */
    public int getSeed() {
        return seed;
    }

    /**
     * Setter method for property <tt>seed</tt>.
     *
     * @param seed value to be assigned to property seed
     */
    public void setSeed(int seed) {
        this.seed = seed;
    }

    /**
     * Getter method for property <tt>webhook</tt>.
     *
     * @return property value of webhook
     */
    public String getWebhook() {
        return webhook;
    }

    /**
     * Setter method for property <tt>webhook</tt>.
     *
     * @param webhook value to be assigned to property webhook
     */
    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    /**
     * Getter method for property <tt>trackId</tt>.
     *
     * @return property value of trackId
     */
    public String getTrackId() {
        return trackId;
    }

    /**
     * Setter method for property <tt>trackId</tt>.
     *
     * @param trackId value to be assigned to property trackId
     */
    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }
}
