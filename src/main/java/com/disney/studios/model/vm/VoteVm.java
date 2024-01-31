package com.disney.studios.model.vm;

/*
* VOTE_UP= voted the dog
* VOTE_DOWN = withdrawn the vote*
* */
public class VoteVm {
    public static int VOTE_UP = 1;
    public  static int VOTE_DOWN = 0;
    private Integer vote;

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
