import http1 from '../http-common';

class CustomerDataService
{
    getAll() {
        return http1.get("/customers");
    }

    get(id) {
        return http1.get(`/customers/${id}`);
    }

    create(data) {
        return http1.post("/customers", data);
    }

    update(id, data) {
        return http1.put(`/customers/${id}`, data);
    }

    delete(id) {
        return http1.delete(`/customers/${id}`);
    }

    // deleteAll() {
    //     return http1.delete(`/book`);
    // }

}
export default new CustomerDataService();