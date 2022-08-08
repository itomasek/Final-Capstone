import axios from 'axios';

export default {
    create(card) {
        return axios.post('/cards', card);
    },

    listCards() {
        return axios.get(`/cards`);
    }
}