package ecomarket.pedido_servicio_servicioso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecomarket.pedido_servicio_servicioso.model.Pedido;
import ecomarket.pedido_servicio_servicioso.repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido modificar(Long id, Pedido pedido) {

        Pedido existente = pedidoRepository.findById(id).orElse(null);

        if (existente != null) {

            existente.setFecha(pedido.getFecha());
            existente.setTotal(pedido.getTotal());
            existente.setSubtotal(pedido.getSubtotal());
            existente.setEstado(pedido.getEstado());
            existente.setUbicacion(pedido.getUbicacion());

            return pedidoRepository.save(existente);
        }

        return null;
    }
}

