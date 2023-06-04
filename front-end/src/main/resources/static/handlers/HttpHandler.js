sap.ui.define('web/school/book/handlers/HttpHandler', function () {
    'use strict'

    async function executeGetRequest(sUrl) {
        return executeRequestJsonResponse("GET", sUrl)
    }

    async function executePostRequest(sUrl, oBody) {
        return executeRequestJsonResponse("POST", sUrl, JSON.stringify(oBody))
    }

    async function executeDeleteRequest(sUrl) {
        return executeRequestTextResponse("DELETE", sUrl)
    }

    async function executePutRequestTestResponce(sUrl) {
        return executeRequestTextResponse("PUT", sUrl)
    }

    async function executePutRequest(sUrl, oBody) {
        return executeRequestJsonResponse("PUT", sUrl, JSON.stringify(oBody))
    }

    async function executeGetRequestTextResponse(sUrl) {
        return executeRequestTextResponse("GET", sUrl)
    }

    async function executeRequestTextResponse(sMethod, sUrl, sBody) {
        try {
            const response = await _executeRequest(sMethod, sUrl, sBody)
            return response.text()
        } catch (e) {
            console.log(e)
            throw e
        }
    }

    async function executeRequestJsonResponse(sMethod, sUrl, sBody) {
        try {
            const response = await _executeRequest(sMethod, sUrl, sBody)
            return response.json()
        } catch (e) {
            console.log(e)
            throw e
        }
    }

    function _executeRequest(sMethod, sUrl, sBody) {
        return fetch(sUrl, {
            method: sMethod,
            body: sBody,
            headers: {
                'Content-Type': 'application/json',
            },
        }).then((response) => _handleStatus(response))
    }

    async function _handleStatus(response) {
        if (!response.ok) {
            throw new Error(`Received statusCode : ${response.status}`)
        }
        return response;
    }

    return {
        executeGetRequestTextResponse: executeGetRequestTextResponse,
        executeGetRequest: executeGetRequest,
        executePostRequest: executePostRequest,
        executeDeleteRequest: executeDeleteRequest,
        executePutRequest: executePutRequest,
        executePutRequestTestResponce: executePutRequestTestResponce
    }
})
