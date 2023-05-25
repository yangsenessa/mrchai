package com.essa.mrchaiemc.biz.models.domains.stablediffusion;

import java.io.Serializable;

public class Text2ImageParams implements Serializable {

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
     * Max Height: Width: 1024x1024.
     */
    protected String width;


    /**
     * Max Height: Width: 1024x1024.
     */
    protected String height;

    /**
     * Number of images to be returned in response. The maximum value is 4.
     */
    protected String samples;

    /**
     * num_inference_steps
     */
    protected String numInferenceSteps;

    /**
     * A checker for NSFW images. If such an image is detected, it will be replaced by a blank image.
     */
    protected String safety_checker = "no";

    /**
     * enhance_prompt
     * Enhance prompts for better results; default: yes, options: yes/no.
     */
    protected String enhancePrompt;

    /**
     * Seed is used to reproduce results, same seed will give you same image in return again. Pass null for a random number.
     */
    protected String seed;

    /**
     * guidance_scale
     * Scale for classifier-free guidance (minimum: 1; maximum: 20).
     */
    protected float guidanceScale;

    /**
     * multi_lingual
     * Allow multi lingual prompt to generate images. Use "no" for the default English.
     */
    protected String multiLingual;

    /**
     * Set this parameter to "yes" to generate a panorama image.
     */
    protected String panorama;

    /**
     * self_attention
     * If you want a high quality image, set this parameter to "yes". In this case the image generation will take more time.
     */
    protected String selfAttention;

    /**
     * upscale
     * Set this parameter to "yes" if you want to upscale the given image resolution two times (2x).
     * If the requested resolution is 512 x 512 px, the generated image will be 1024 x 1024 px.
     */
    protected String upScale;

    /**
     * embeddings_model
     * This is used to pass an embeddings model (embeddings_model_id).
     */
    protected String embeddingsModel;

    /**
     * Set an URL to get a POST API call once the image generation is complete.
     */
    protected String webhook;

    /**
     * This ID is returned in the response to the webhook API call. This will be used to identify the webhook request.
     */
    protected String trackId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getNegativePrompt() {
        return negativePrompt;
    }

    public void setNegativePrompt(String negativePrompt) {
        this.negativePrompt = negativePrompt;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSamples() {
        return samples;
    }

    public void setSamples(String samples) {
        this.samples = samples;
    }

    public String getNumInferenceSteps() {
        return numInferenceSteps;
    }

    public void setNumInferenceSteps(String numInferenceSteps) {
        this.numInferenceSteps = numInferenceSteps;
    }

    public String getSafety_checker() {
        return safety_checker;
    }

    public void setSafety_checker(String safety_checker) {
        this.safety_checker = safety_checker;
    }

    public String getEnhancePrompt() {
        return enhancePrompt;
    }

    public void setEnhancePrompt(String enhancePrompt) {
        this.enhancePrompt = enhancePrompt;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public float getGuidanceScale() {
        return guidanceScale;
    }

    public void setGuidanceScale(float guidanceScale) {
        this.guidanceScale = guidanceScale;
    }

    public String getMultiLingual() {
        return multiLingual;
    }

    public void setMultiLingual(String multiLingual) {
        this.multiLingual = multiLingual;
    }

    public String getPanorama() {
        return panorama;
    }

    public void setPanorama(String panorama) {
        this.panorama = panorama;
    }

    public String getSelfAttention() {
        return selfAttention;
    }

    public void setSelfAttention(String selfAttention) {
        this.selfAttention = selfAttention;
    }

    public String getUpScale() {
        return upScale;
    }

    public void setUpScale(String upScale) {
        this.upScale = upScale;
    }

    public String getEmbeddingsModel() {
        return embeddingsModel;
    }

    public void setEmbeddingsModel(String embeddingsModel) {
        this.embeddingsModel = embeddingsModel;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }
}
