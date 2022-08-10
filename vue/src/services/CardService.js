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

    listDecks(userId) {
        return axios.get(`/decks/${userId}`);
    }
}