import axios from 'axios';

export default {
    create(card) {
        return axios.post('/cards', card);
    },

    listCards(id) {
        return axios.get(`/cards/${id}`);
    },
    updateCard(cardId, card) {
        return axios.put(`/card/${cardId}`, card)
    },

    updateDeck(deckId, deck) {
        return axios.put(`/deck/${deckId}`, deck)
    },

    listDecks(userId) {
        return axios.get(`/decks/${userId}`);
    },

    createDeck(deck) {
        return axios.post('/decks', deck);
    },

    getNumberOfCards(deckId) {
        return axios.get(`/deck-cards/${deckId}`);
    },

    putCardsInDeck(cardId, deckId) {
        return axios.post(`/cards/${cardId}/decks/${deckId}`);
    },

    getCardsByDeckId(deckId) {
        return axios.get(`/cards-in/${deckId}`);
    },

    getExcludedCards(userId, deckId) {
        return axios.get(`/cards-out/${userId}/${deckId}`);
    },

    clearCardDeck(deckId) {
        return axios.delete(`/clear-card-deck/${deckId}`);
    },

    saveSession(session) {
        return axios.post(`/save-session`, session);
    }
}