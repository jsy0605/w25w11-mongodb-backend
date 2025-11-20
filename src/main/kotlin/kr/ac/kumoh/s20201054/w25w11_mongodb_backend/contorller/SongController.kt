package kr.ac.kumoh.s20201054.w25w11_mongodb_backend.contorller

import kr.ac.kumoh.s20201054.w25w11_mongodb_backend.model.Song
import kr.ac.kumoh.s20201054.w25w11_mongodb_backend.service.SongService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = ["http://localhost:5173"])
class SongController (private val service: SongService){
    @GetMapping
    fun getAllSongs(): List<Song> = service.getAllSongs()

    @GetMapping("/{id}")
    fun getSongById(@PathVariable id: String): Song? = service.getSongById(id)
}