package org.kethereum.erc681

fun ERC681.generateURL(): String {
    var res = "ethereum:"
    if (prefix != null) {
        res += "$prefix-"
    }

    if (address != null) {
        res += address
    }

    chainId?.let {
        res += "@${it.value}"
    }

    if (function != null) {
        res += "/$function"
    }

    val paramList = mutableListOf<Pair<String, String>>()

    paramList.addAll(functionParams)

    if (gas != null) {
        paramList.add("gas" to gas.toString())
    }
    if (value != null) {
        paramList.add("value" to value.toString())
    }
    if (paramList.isNotEmpty()) {
        res += "?" + paramList.joinToString("&") { it.first + "=" + it.second }
    }

    return res

}
